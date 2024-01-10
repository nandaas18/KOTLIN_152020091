package app.example.parsing.datamodel

class DataGempa {
    var Infogempa : InfoGempa = InfoGempa()

}

class InfoGempa {
    var gempa : Gempa = Gempa()

}

class Gempa {
    var Tanggal : String = ""
    var Jam : String = ""
    var DateTime : String = ""
}