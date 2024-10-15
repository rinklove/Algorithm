const val SIZE: Int = 100
val map = Array(SIZE) { BooleanArray(SIZE){false} }

fun main() {
    val count = readln().toInt()

    for (i in 1..count) {
        val data = readln().split(" ")
        val x = data[0].toInt()
        val y = data[1].toInt()
        addArea(x, y)
    }

    println(getArea());
}

fun getArea(): Int {
    return map.sumOf{ row -> row.count {per -> per.equals(true) } }
}

fun addArea(startX: Int, startY:Int) {
    for (x in startX until startX+10) {
        for (y in startY until startY+10) {
            map[x][y] = true;
        }
    }
}