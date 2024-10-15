import kotlin.math.max

fun main() {

    var arr: Array<String> = Array(5, {""});
    var max = 0;

    for (i in 0 until arr.size) {
        val value = readln();
        max = max(max, value.length);
        arr[i] = value;
    }

    var answer: String = "";

    for(x in 0 until max) {
        for (y in 0..4) {
            if(arr[y].length <= x) continue
            answer = answer.plus(arr[y][x])
        }
    }

    println(answer)
}