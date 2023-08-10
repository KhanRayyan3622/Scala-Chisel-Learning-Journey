// package Lab_2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class Task1_Tester extends FreeSpec with ChiselScalatestTester {
//   "task1 Tester file" in {
//     test(new Mux_5to1) { b =>
//         b.io.s0.poke(0.B)
//         b.io.s1.poke(0.B)
//         b.io.s2.poke(1.B)
//         b.clock.step(1)
//         b.io.out.expect(32.U)

//     }
//   }
// }

