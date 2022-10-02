package pl.pollub.harnasik.app.data.remote

object HttpRoutes {
    //    THIS VALUE IS HARDCODED BECAUSE THIS WAY IT WORKS :)
    //    IT'S IPV4 ADDRES FROM YOUR PC NETWORK
    private const val IP_ADDRESS = "192.168.0.17"
    private const val BASE_URL = "http://$IP_ADDRESS:8080/api"
    const val ALL_OFFERS = "$BASE_URL/offer"
    const val OFFER = "$BASE_URL/offer/"

}