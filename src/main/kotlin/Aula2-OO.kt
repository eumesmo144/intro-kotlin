package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 7) {
        menu()
        print("Digite a opção: ")
        val input = readLine()
        opcao = input?.toIntOrNull() ?: 0
        when (opcao) {
//            0 -> {
//                val animal = repositorioAnimal
//                val corAnimal = Animal.Cor.Vermelho;
//                animal.nome = "genérico"
//                repositorioAnimal.adicionar(animal)
//            }
            1 -> {
                val cachorro = criarCachorro()
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                val gato = criarGato()
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                val passaro = criarPassaro()
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                val pessoa = criarHomem()
                repositorioAnimal.adicionar(pessoa)
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)

            }
            7 -> {
                println("Animal que se deseja remover: ")
                val nomeAnimal = readLine()
                repositorioAnimal.remove(nomeAnimal ?: "")
            }
            8 -> println("Indo ali...")
        }

    }
}
fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Homem")
    println("5 - Listar animais")
    println("6 - Emitir som")
    println("7 - Remover animal")
    println("8 - Sair")
}
fun criarCachorro(): Cachorro {
    println("Informe o nome do cachorro: ")
    val nome = readLine()
    println("Informe a idade do cachorro: ")
    val idade = readLine()?.toIntOrNull()
    println("Informe a cor do cachorro: ")
    val cor = readLine()
    return Cachorro(idade ?: 0, cor?: "").apply { this.nome = nome ?: ""}
}
fun criarGato(): Gato {
    println("Informe o nome do gato: ")
    val nome = readLine()
    println("Informe a idade do gato: ")
    val idade = readLine()?.toIntOrNull()
    println("Informe a cor do gato: ")
    val cor = readLine()
    return Gato(idade ?: 0, cor?: "").apply { this.nome = nome ?: ""}
}
fun criarPassaro(): Passaro {
    println("Informe o nome do passaro: ")
    val nome = readLine()
    println("Informe a idade do passaro: ")
    val idade = readLine()?.toIntOrNull()
    println("Informe a cor do passaro: ")
    val cor = readLine()
    return Passaro(idade ?: 0, cor?: "").apply { this.nome = nome ?: ""}
}
fun criarHomem(): Homem {
    println("Informe o nome do Homem: ")
    val nome = readLine()
    println("Informe a idade do Homem: ")
    val idade = readLine()?.toIntOrNull()
    println("Informe a cor do Homem: ")
    val cor = readLine()
    return Homem(idade ?: 0, cor?: "").apply { this.nome = nome ?: ""}
}
abstract class Animal(var idade: Int, var cor: String) {
    open var nome: String = ""
        get() = "Animal: $field"
        set(valor) {
            field = valor
        }
//cor.valueof

    abstract fun emitirSom()
    open fun idadeHumana(): Int {
        return idade * 7
    }
    enum class Cor{
        Vermelho,
        Amarelo,
        Azul,
        Marrom
    }
}

class Cachorro(idade: Int, cor: String) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, cor: String) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, cor: String) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}
class Homem(idade: Int, cor: String): Animal(idade, cor){
    override fun emitirSom(){
        println("Opa :^)")
    }

    override fun idadeHumana(): Int {
        return super.idadeHumana() / 7
    }
}



class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }
    fun buscaNome(nomeAnimal: String): Animal?{
        var search = animais.find { it.nome == nomeAnimal }
        return animais.find { it.nome == nomeAnimal }
    }
    fun remove(nomeAnimal: String){
        val animalRmv = buscaNome(nomeAnimal)
        if (animalRmv != null){
            animais.remove(animalRmv)
            print("Animal $animalRmv removido")
        }else{
            print("Animal $animalRmv não encontrado")
        }
    }
    fun listaCor(cor: String){
        val animaispCor = animais.filter { it.cor.toString() == cor.uppercase() }
        animaispCor.forEach{ println(it.nome)}
    }
}


