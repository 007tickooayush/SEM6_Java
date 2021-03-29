package PBLJ.Customs.Custom1

import org.omg.CORBA.Object

class CustomArray<v>{
    private lateinit var objList:ArrayList<Any>
    private var added = 0
    var size = 10
    var cap = 0

    init {
        this.added = 0
        this.size = 11
        this.cap = 0
        objList = arrayListOf()
    }
    constructor()  {
        this.added = 0
        this.size = 11
        objList = arrayListOf()
    }

    constructor(size:Int,cap:Int){
        this.size = size
        this.cap = cap
        this.added=0
    }
    constructor(size: Int):this(size, 0){}

    fun add(`value`: v) {
        objList.add(value!!)
        added++
    }

    fun printList(){
        print(objList)
    }

    fun getList():ArrayList<Any>{
        return objList
    }
}

fun main() {
    val ch = CustomArray<String>(6)
    ch.add("Ayu")
    ch.add("sh ")
    ch.add("Tic")
    ch.add("koo")
    ch.printList()
    println()
    for(word in ch.getList()){
        print(word)
    }

}