// package practice

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class HalfAdderTester extends FreeSpec with ChiselScalatestTester {
// "adder Tester file" in {
//     test (new HalfAdder) { a =>
//         a.io.in1.poke(7.U)
//         a.io.in2.poke(7.U)
//         a.clock.step(1)
//         a.io.out.expect(0.U)
//         a.io.cout.expect(7.U)
//     }
// }
// }