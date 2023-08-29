// package practice

// import chisel3._
// import chisel3.util._
// import org.scalatest.FreeSpec
// import chisel3.tester._
// import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotation
// import scala.util.Random
// import chisel3.experimental.BundleLiterals._

// class txrx  extends FreeSpec with ChiselScalatestTester {
// "tx rx test" in {
// test ( new tx ) { a =>
// a.io.tx.poke(1.B)
// a.io.ready.poke(1.B)
// a.io.data.expect(1.B)
// a.io.valid.expect(3.U)
// // a.io.datarx.expect(0.U)
// a.clock.step(10)
// }
// }
// }


