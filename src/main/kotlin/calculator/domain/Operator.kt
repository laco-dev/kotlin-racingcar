package calculator.domain

enum class Operator(val code: String, val operate: (Number, Number) -> Number) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLE("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun from(codetype: String): Operator {
            return values().firstOrNull { it.code == codetype } ?: throw IllegalArgumentException("허용하지 않는 연산자")
        }
    }
}