package racingcar.model

import racingcar.RacingCarForwardCondition

/**
 * 현재는 자동차를 index 기반으로 생성하고 있지만
 * 자동차들을 외부에서 주입받아 처리하려면 추상화를 통해 여러개의 Cars 구현체로 가능할 듯
 */
class Cars(
    val carCount: CarCount,
    private val condition: RacingCarForwardCondition
) {

    private var cars: List<Car> = List(carCount.count) { index -> Car(id = index + 1) }

    fun move() {
        this.cars = cars.map { car -> car.tryMove(condition) }
    }

    private fun Car.tryMove(condition: RacingCarForwardCondition): Car =
        if (condition.isForward()) {
            forward()
        } else {
            backward()
        }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
