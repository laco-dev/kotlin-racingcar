package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingCarGameResult

class ConsoleResultView(
    private val carSymbol: String = DEFAULT_CAR_SYMBOL
) : ResultView {

    override fun showGameStart() {
        printDivider()
        println("자동차 경주를 시작합니다.")
    }

    override fun showGameRoundStart(round: Int, cars: List<Car>) {
        println("현재 라운드: $round")
    }

    override fun showGameRoundEnd(round: Int, cars: List<Car>) = printCarPositions(cars)

    override fun showGameResult(result: RacingCarGameResult) {
        println("자동차 경주를 종료합니다.")
        println("총 자동차 대수: ${result.carCount.count}")
        println("총 시도한 횟수: ${result.gameCount.count}")
        printCarPositions(result.cars)
        printDivider()
    }

    private fun printCarPositions(cars: List<Car>) {
        cars.forEachIndexed { index, car ->
            print("${index + 1}: ")
            repeat(car.position) { print(carSymbol) }
            println()
        }
        println()
    }

    private fun printDivider() = println("---------------------------------------------")

    companion object {
        private const val DEFAULT_CAR_SYMBOL = "-"
    }
}
