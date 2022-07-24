/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

typealias Duration = Long

/******************************************************************
 * Includes data of a song like it name, duration and tracknumber
 */
data class Song(
    //Main constructor
    val name: String, 
    val duration: Duration
){
    var trackNumber: Int? = null
    
    //Secondary constructor
    constructor(name: String, duration: Duration, trackNumber:Int?) : this (name, duration){
        this.trackNumber = trackNumber
    }
    
    //Override toString
    override fun toString(): String {
        return if (trackNumber == null) "$name - " + duration.getStringDuration()
      	else "$trackNumber. $name - " + duration.getStringDuration() 	
    }
}
//*****************************************************************

/******************************************************************
 * Includes data of a disc like it name and the songs
 */
data class Disc(
    //Main constructor
    val name: String,
    val songs: List<Song>
){
    //Override toString
    override fun toString(): String{
        return "$name, " + songs.size + " songs on it"
    }
}
//*****************************************************************

/******************************************************************
 * Includes data of an artist like it name, country, discography,
 * type and singles.
 */
data class Artist(
    //Main constructor
    val name: String,
    val country: String
){
    var discography: List<Disc> = listOf()
    var type: String = ""
    var singles: List<Song> = listOf()
    
    //Secondary constructor
    constructor (name: String, country: String, discography: List<Disc>, type: String) : this (name, country){
        this.discography = discography
        this.type = type
    }
    
    //Override toString
    override fun toString(): String{
        return if (singles.size == 0) 
                "$name is a $type from $country. " + type.capitalize() + " has " + discography.size + " discs and no singles" 
            else 
                "$name is a $type from $country. " + type.capitalize() + " has " + discography.size + " discs and " + singles.size + " singles"
    }
}
//*****************************************************************

/******************************************************************
 * Converts a duration in milliseconds to mm:ss format
 * @ExtensionFunction
 */
fun Duration.getStringDuration(): String = 
    "" + this / 60000 + ":" + 
    if	(((this % 60000) / 1000) > 9) 
		(this % 60000) / 1000 
	else 
		"0" + (this % 60000) / 1000
//*****************************************************************

/******************************************************************
 * Gets the first two songs of a sorted list by it trackNumber
 * @ExtensionFunction
 */
fun List<Song>.getFirstTwoSongs(): Pair<Song, Song> {
    var listSorted = this.sortedWith(compareBy{it.trackNumber})
    return Pair(listSorted.get(0), listSorted.get(1)) 
} 
//*****************************************************************