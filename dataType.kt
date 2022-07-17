/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String,
    var info: String
)
// -----------------------

/******************************************************************
 * Controls the execution of the program managing the other methods
 */
fun main() {
    val result = processList(listOf(10, "Enero", null, true))

    println(result)
}
//*****************************************************************

/******************************************************************
 * Determines the items properties of the ArrayList to return
 * @param inputList - List created by the user in main method
 * @return ArrayList<ItemData>? - An ArrayList with the items
 */
fun processList(inputList: List<Any?>?): ArrayList<ItemData>? {
    var outputList: ArrayList<ItemData>? = arrayListOf() //ArrayList to return 
    
	if (inputList == null) //input null ↔ output null
        outputList = null
     
    else{
        for ((index, item) in inputList.withIndex()){ //Evaluates each item in inputList
            if (item != null){ //analyze item ↔ ¬ null
                //Properties assigment
                var newItem = ItemData(
              		originalPos = index,
  					originalValue = item,
  					type = checkType(item),
  					info = checkInfo(item)
  				)
               
                //Adds a new item
                outputList?.add(newItem)
            }
        }
    }
    
    return outputList;
}
//*****************************************************************

/******************************************************************
 * Returns the item data type. Only determines Int, String and 
 * Boolean as known
 * @param item - Any data type
 * @return String - Item data type 
 */
fun checkType(item: Any): String {
	return when(item) {
        is Int -> "entero"
        is String -> "cadena"
        is Boolean -> "booleano"
        else -> "desconocido"
    }
}
//*****************************************************************

/******************************************************************
 * Returns the item info depending of the data type
 	* Int: Maximum multiple (allows 2, 5 or 10 as multiples)
    * String: Length of the item
    * Boolean: State of the item
 * @param item - Any data type
 * @return String - Item info
 */
fun checkInfo(item: Any): String{
    return when(item){
        is Int -> multipleInt(item) 
        is String -> "L" + item.length
        is Boolean -> if (item) "verdadero" else "falso"
        else -> "desconocido"
    }
}
//*****************************************************************

/******************************************************************
 * Returns the maximum multiple of a number (allows 2, 5 or 10 as 
 * multiples)
 * @param int - Int number to analyze
 * @return String - Multiple of the int
 */
fun multipleInt(int: Int): String {
    var info: String = "-"
    
    if (int % 10 == 0)
    	info = "M10"
    else
    	if (int % 5 == 0)
    		info = "M5"
        else
            if (int % 2 == 0)
                info = "M2"
    
    return info
}
//*****************************************************************