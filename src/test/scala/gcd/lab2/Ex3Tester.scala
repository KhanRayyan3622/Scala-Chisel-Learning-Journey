// package lab2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class Ex3tester extends FreeSpec with ChiselScalatestTester{
//     "Ex2tester file " in {
//         test(new mux_onehot_4to1 ){  a =>
//         a.io.in0.poke("b0001".U)
//         a.clock.step(1)
        
//         a.io.out.expect(0.U)
//         }}}