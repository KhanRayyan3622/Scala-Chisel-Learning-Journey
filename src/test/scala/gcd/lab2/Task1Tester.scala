// package lab2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class Task1tester extends FreeSpec with ChiselScalatestTester{
//     "Ex2tester file " in {
//         test(new Mux_5to1){ a =>
//         a.io.sel.poke(0.U)
//         a.clock.step(1)
//         a.io.out.expect(0.U)
//         }}}