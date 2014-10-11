/**
 * Created by saginawj on 10/10/14.
 */

import org.scalatest._

class TestHarness extends FlatSpec with Matchers {

  "A stack" should "do stuff" in {

    val stack = 1

    stack should be (1)

  }

}
