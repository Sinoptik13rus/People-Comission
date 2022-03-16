import kotlin.system.exitProcess

val summInRub = 10_500_000
val kopInRub = 100
val amount = summInRub * kopInRub
var percentSummForCard = 0.0
val cardName = "VK Pay"
val maxTransfer = 150000 * kopInRub
val maxTransferVKPay = 15000 * kopInRub
val maxAmountForMasterMaestro = 75000 * kopInRub
val minAmount = 300
val minAmountInCop = minAmount * kopInRub

fun main() {
    val finishResult = amountCalculation(cardName, maxTransfer, amount)
    val finishResultInRub: Double = (finishResult / 100).toDouble()
    println("Общая комиссия от суммы $summInRub оставила $finishResultInRub руб.")

}

fun amountCalculation(cardName: String, maxTransfer: Int, amount: Int): Double {
    when (cardName) {
        "Mastercard", "Maestro" -> percentSummForCard = mastercardMaestro(amount)
        "Visa", "Мир" -> percentSummForCard = visaMir(amount)
        "VK Pay" -> if (amount <= maxTransferVKPay) {
            percentSummForCard
        } else {
            println("Сумма превышает суточный лимит")
            System.exit(0)
        }
    }
    return percentSummForCard

}

fun mastercardMaestro(amount: Int): Double {
    val summForPercent = 20 * kopInRub
    val minPercent = 0.6
    var percent = 0.0

    if (amount > maxTransfer) {
        println("Сумма превышает суточный лимит")
        System.exit(0)
    } else
        if ((amount < minAmountInCop) && (amount > maxAmountForMasterMaestro)) {
            percent = ((amount / 100 * minPercent) + summForPercent)
        }
    return percent

}

fun visaMir(amount: Int): Double {
    val comissionPercent = 0.75
    val minComission = 35 * kopInRub
    val percentSumm = (amount / 100 * comissionPercent)
    var percent = percentSumm

    if (amount > maxTransfer) {
        println("Сумма превышает суточный лимит")
        System.exit(0)
    } else
        if (percentSumm < minComission) {
            percent = minComission.toDouble()
        }
    return percent

}