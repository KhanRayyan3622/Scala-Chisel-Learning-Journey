// package practice

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class OrTester extends FreeSpec with ChiselScalatestTester {
// "Sub Tester file" in {
//     test (new OR) { a =>
//         a. io.in1.poke(0.U)
//         a.io.in2.poke(0.U)
//         a.clock.step(1)
//         a.io.out.expect(0.U)
//     }
// }
// }