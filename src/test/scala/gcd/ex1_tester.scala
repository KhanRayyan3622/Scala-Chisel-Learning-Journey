// package Lab_2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class Task2_Tester extends FreeSpec with ChiselScalatestTester {
//   "task1 Tester file" in {
//     test(new Mux_2to1) { b =>
//         b.io.in_A.poke(0.U)
//         b.io.in_B.poke(1.U)
//         b.io.select.poke(0.B)
//         b.io.out.expect(1.U)
//         b.clock.step(1)

//     }
//   }
// }
