package recfun

object Main {
    def main(args: Array[String]) {
        println("Pascal's Triangle")
        for (row <- 0 to 10) {
            for (col <- 0 to row)
                print(pascal(col, row) + " ")
            println()
        }
        println("\nParentheses Balancing")
        println("(if (zero? x) max (/ 1 x)) " + balance("(if (zero? x) max (/ 1 x))".toList))
        println("I told him (that it’s not (yet) done). (But he wasn’t listening) " + balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
        println(":-) " + balance(":-)".toList))
        println("())( " + balance("())(".toList))

        print(countChange(5, List(1,2)))
    }

    /**
      * Exercise 1
      */
    def pascal(c: Int, r: Int): Int =
        if ((c == 0) || (r == c)) 1
        else pascal(c - 1, r - 1) + pascal(c, r - 1)

    /**
      * Exercise 2
      */
    def balance(chars: List[Char]): Boolean = {
        def checkBalance(chars: List[Char] , count: Int): Boolean = {
            if (count < 0) false
            else if (count == 0 && chars.isEmpty) true
            else if (chars.isEmpty) false
            else if (chars.head == '(') checkBalance(chars.tail, count + 1)
            else if (chars.head == ')') checkBalance(chars.tail, count - 1)
            else checkBalance(chars.tail, count)
        }
        checkBalance(chars, 0)
    }

    /**
      * Exercise 3
      */
    def countChange(money: Int, coins: List[Int]): Int = {
        if (money < 0) 0
        else if (money == 0) 1
        else if (coins.isEmpty) 0
        else {
            countChange(money - coins.head, coins) +
                countChange(money , coins.tail)
        }
    }
}
