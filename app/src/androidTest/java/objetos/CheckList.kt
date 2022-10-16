package objetos

import kotlin.properties.Delegates

class CheckList {

    lateinit var placa: String
    lateinit var usuario: String
    lateinit var data: String
    var finalizado: Boolean by Delegates.notNull()
    var item1 by Delegates.notNull<Boolean>()
    var item2 by Delegates.notNull<Boolean>()
    var item3 by Delegates.notNull<Boolean>()
    var item4 by Delegates.notNull<Boolean>()
    var item5 by Delegates.notNull<Boolean>()
    var item6 by Delegates.notNull<Boolean>()
    var item7 by Delegates.notNull<Boolean>()
    var item8 by Delegates.notNull<Boolean>()
    var item9 by Delegates.notNull<Boolean>()

    constructor(placa: String, usuario: String, data: String, finalizado: Boolean, item1: Boolean, item2: Boolean, item3: Boolean, item4: Boolean, item5: Boolean, item6: Boolean, item7: Boolean, item8: Boolean, item9: Boolean) {
        this.placa = placa
        this.usuario = usuario
        this.data = data
        this.finalizado = finalizado
        this.item1 = item1
        this.item2 = item2
        this.item3 = item3
        this.item4 = item4
        this.item5 = item5
        this.item6 = item6
        this.item7 = item7
        this.item8 = item8
        this.item9 = item9
    }

}