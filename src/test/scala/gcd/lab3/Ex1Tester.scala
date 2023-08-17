<<<<<<< HEAD
package lab3
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Ex1Tester extends FreeSpec with ChiselScalatestTester{
    "Encoder tester file"in{
        test(new  Encoder4to2) {a =>
        a.io.in.poke(1.U)
        a.io.out.expect(0.U)
        a.clock.step(1)

    }
 }
=======
package lab3
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Ex1Tester extends FreeSpec with ChiselScalatestTester{
    "Encoder tester file"in{
        test(new  Encoder4to2) {a =>
        a.io.in.poke(1.U)
        a.io.out.expect(0.U)
        a.clock.step(1)

    }
 }
>>>>>>> 2e1319e6bffb73bba5864a2df60603b04df9c27a
 }