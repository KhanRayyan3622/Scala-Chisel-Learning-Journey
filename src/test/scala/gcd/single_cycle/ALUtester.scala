package single_cycle

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ALUData extends FreeSpec with ChiselScalatestTester {
  "alu Tester file" in {
    test(new ALUD){a =>
        a.io.in_A.poke(10.U)
        a.io.in_B.poke(9.U)
        a.io.aluop.poke(0.U)
        // a.io.fun7.poke("b0000000".U)
          a.clock.step(5)
        a.io.out.expect(19.U)

         b.io.fnct3.poke("b000".U)

       b.io.arg_x.poke(4.U)
       b.io.arg_y.poke(4.U)
       b.io.br_taken.expect(1.B)
//        b.clock.step(10)
    
   // a.clock.step(10)

    }
  }
}

