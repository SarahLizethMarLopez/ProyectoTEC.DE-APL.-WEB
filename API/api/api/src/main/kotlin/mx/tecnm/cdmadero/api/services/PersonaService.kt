package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Persona
    import mx.tecnm.cdmadero.api.repositories.DireccionRepository
    import mx.tecnm.cdmadero.api.repositories.PersonaRepository
    import org.springframework.stereotype.Service
    import org.springframework.transaction.annotation.Transactional
    import java.time.LocalDate
    import java.util.*

    @Service
    class PersonaService(
        private val personaRepository: PersonaRepository,
        private val direccionRepository: DireccionRepository
    ) {


        fun findAllPersona(): List<Persona> = personaRepository.findAll()

        fun findPersonaById(id: UUID): Optional<Persona> = personaRepository.findById(id)

        @Transactional
        fun savePersona(persona: Persona): Persona {
            if (persona.idDireccion == null) {
                return Persona()
            }

            val curp = persona.curp ?: ""
//            validacion con patron
//            if (curp.matches(Regex("[0-9]+"))) {
//                return Persona()
//            }
            val fechaCurp = curp.substring(4, 10) // AAMMDD
            val sexo = curp[10]               // H o M

            val anio = fechaCurp.substring(0, 2).toInt()
            val mes = fechaCurp.substring(2, 4).toInt()
            val dia = fechaCurp.substring(4, 6).toInt()

            val siglo = if (curp[16] == '0') 1900 else 2000
            val anioCompleto = siglo + anio

            val fechaNacimiento = try {
                LocalDate.of(anioCompleto, mes, dia)
            } catch (e: Exception) {
                null // fecha inválida
            }

            persona.id = UUID.randomUUID()
            persona.idDireccion!!.id = UUID.randomUUID()
            direccionRepository.save(persona.idDireccion!!)
            persona.fechaNacimiento = fechaNacimiento
            persona.sexo = if (sexo == 'M') 'F' else 'M'
            return personaRepository.save(persona)
        }

        fun deletePersona(id: UUID) = personaRepository.deleteById(id)

        fun findByNss(nss: String): Persona? {
            return personaRepository.findByNss(nss)
        }

        fun findById(id: UUID): Persona {
            return personaRepository.findById(id).orElseThrow {
                NoSuchElementException("No se encontró el paciente con ID: $id")
            }
        }

        fun updatePersona(persona: Persona): Persona {
            val existente = personaRepository.findById(persona.id ?: throw IllegalArgumentException("ID nulo")).orElseThrow()
            val (fechaNacimiento, sexo) = extraerDatosDesdeCurp(persona.curp ?: "")
            if (fechaNacimiento == null) {
                throw IllegalArgumentException("El CURP proporcionado no contiene una fecha válida.")
            }

            existente.apply {
                this.nombre = persona.nombre
                this.apellidoPaterno = persona.apellidoPaterno
                this.apellidoMaterno = persona.apellidoMaterno
                this.curp = persona.curp
                this.nss = persona.nss
                this.fechaNacimiento = fechaNacimiento
                this.sexo = sexo
                this.institucion = persona.institucion
                this.idTipoSanguineo = persona.idTipoSanguineo

                if (persona.idDireccion != null) {
                    this.idDireccion?.apply {
                        this.calle = persona.idDireccion!!.calle
                        this.colonia = persona.idDireccion!!.colonia
                        this.codigoPostal = persona.idDireccion!!.codigoPostal
                        this.numeroInterior = persona.idDireccion!!.numeroInterior
                        this.numeroExterior = persona.idDireccion!!.numeroExterior
                        this.idEstado = persona.idDireccion!!.idEstado
                    }
                    direccionRepository.save(this.idDireccion!!)
                }
            }

            return personaRepository.save(existente)
        }

        private fun extraerDatosDesdeCurp(curp: String): Pair<LocalDate?, Char> {
            return try {
                if (curp.length < 18) throw IllegalArgumentException("CURP inválido")

                val fechaCurp = curp.substring(4, 10)
                val sexoChar = curp[10]

                val anio = fechaCurp.substring(0, 2).toInt()
                val mes = fechaCurp.substring(2, 4).toInt()
                val dia = fechaCurp.substring(4, 6).toInt()
                val siglo = if (curp[16] == '0') 1900 else 2000
                val anioCompleto = siglo + anio

                val fechaNacimiento = LocalDate.of(anioCompleto, mes, dia)
                val sexo = if (sexoChar == 'M') 'F' else 'M'

                Pair(fechaNacimiento, sexo)
            } catch (e: Exception) {
                Pair(null, 'M') // Valor por defecto si falla
            }
        }
    }
