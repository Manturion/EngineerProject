package pl.pollub.harnasik.app.data.remote

object HttpRoutes {
    //    THIS VALUE IS HARDCODED BECAUSE THIS WAY IT WORKS :)
    //    IT'S IPV4 ADDRES FROM YOUR PC NETWORK
    private const val BASE_URL = "http://192.168.1.41:8080/api"
    const val ALL_OFFERS = "$BASE_URL/offer"
    const val OFFER = "$BASE_URL/offer/{id}"

}