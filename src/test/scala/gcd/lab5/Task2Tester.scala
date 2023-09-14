package lab5
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Task2tester extends FreeSpec with ChiselScalatestTester {
     "packet tester" in {
         test(new Router(UInt(16.W))){ a =>
         a. io.in.data.poke(1.U)
        a.io.in.address.poke(5.U)
         a.clock.step(1)
         a.io.out.address.expect(5.U)


    }
}
 }


