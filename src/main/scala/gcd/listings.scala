// package Lab_2

// import chisel3._
// import chisel3.util._

// class chisel_2M extends Module {
//     val io = IO(new Bundle {
//         val in1 = Input(UInt(3.W))
//         val in2 = Input(UInt(3.W))
//         val out = Output(UInt(3.W))
//     })
//     io.out := io.in1 & io.in2
// }

// class Mux_2to1_IO extends Bundle {
//     val in_A = Input(Bool())
//     val in_B = Input(Bool())
//     val select = Input(Bool())
//     val out = Output(Bool())
// }

// // Implementation of 2 to 1 Mux
// class Mux_2to1 extends Module{
//     val io=IO(new Mux_2to1_IO)


// // update the output
//     io.out := io.in_A & io.select | io.in_B & io.select

// println((new chisel3.stage.ChiselStage).emitVerilog (new Mux_2to1()))
// }

// // Listing 2.5: Mux 2-to-1 with vector inputs.
// class Mux_2to1_32_IO extends Bundle{
//     val in_A = Input(UInt(32.W))
//     val in_B = Input(UInt(32.W))
//     val select = Input(Bool())
//     val out= Output(UInt())
// }

// // 2 to 1 mux implementation
// class Mux_2to_1 extends Module{
//     val io=IO(new Mux_2to1_32_IO)

// //update the output
//     io.out:= Mux(io.select, io.in_A, io.in_B)

// println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_2to_1()))
// }

// -----------------------------------------------------------------------------------------------------------------------------
//Listing 2.7: Mux 4-to-1 with input priority
// Mux with input priority
import chisel3 . _
class IO_Interface extends Bundle {
    val in = Input ( UInt (4. W ) )
    //since its 4-to-1 Mux with input as priority, so there are 4 inputs and 3 selection lines.
    val s1 = Input ( Bool () )
    val s2 = Input ( Bool () )
    val s3 = Input ( Bool () )
    val out = Output ( Bool () ) // UInt (1. W))
}
// A Chisel module Mux_Tree is defined, which represents the priority-based 4-to-1 multiplexer.
class Mux_Tree extends Module {
    val io = IO (new IO_Interface )
    // Declaring the io object using the defined interface is a fundamental concept in Chisel that facilitates connecting the 
    // internal signals of a module to the external world. 
    // The io object acts as a bridge between the internal logic of the module and the external signals it interacts with.
    // Pehlay agar s3 true ha toh io.in(3) output aajaye ga, agar s3 is false; aur s2 true ha toh io.in(2); aur agar dono ghlt hain 
    // aur s1 is true; phir io.in(1) output aajaye ga aur agr If none of the control signals are true, select io.in(0) as the output.
    io.out := Mux (io.s3, io.in(3) , Mux( io . s2 , io . in (2) ,
    Mux( io . s1 , io . in (1) , io . in (0) ) ) )

    // Finally, the Verilog code for the Mux_Tree module is generated using Chisel's ChiselStage, and it's printed to the console.
    // Bcz for verification and debugging.
println((new chisel3.stage.ChiselStage ).emitVerilog(new Mux_Tree()))
}

//-------------------------------------------------------------------------------------------------------------------------------------
// Listing 2.10: Mux1H illustration for four inputs.
// the usage of the Mux1H construct, which is a multiplexer where each select line corresponds to one input. 
// The select lines are "one-hot," meaning that only one select line should be high (1) at a time. If multiple select lines are high,
// the output is undetermined.
class mux_onehot_4to1 extends Module {
  val io = IO(new Bundle {
    // 32 bit input and outputs each
    val in0 = Input(UInt(32.W))
    val in1 = Input(UInt(32.W))
    val in2 = Input(UInt(32.W))
    val in3 = Input(UInt(32.W))
    val sel = Input(UInt(4.W)) //4 bit selection lines
    val out = Output(UInt(32.W))
  })
// select signal io.sel, The second argument is a sequence (Scala collection) of input signals io.in0 to io.in3. 
// The selected input will be the one corresponding to the high (1) bit in the sel signal.
  io.out := Mux1H(io.sel, Seq(io.in0, io.in1, io.in2, io.in3))

println((new chisel3.stage.ChiselStage).emitVerilog(new mux_onehot_4to1()))
}

//-------------------------------------------------------------------------------------------------------------------------------------
// 2.4 Flipped and Bulk constructs
// If we want to change the direction of any signal or a bundle of signals, we simply flip the bundle by
// applying the Flipped construct and the direction of all the signals is reversed i.e. from inputs are
// changed to outputs and vice versa. This is quite useful in scenarios where we are using bundles that
// are input to one module and output to another module.
// We can also connect IO signals with same names across different modules by using the bulk connector
// <>. One scenario, where this would be useful, is a master/slave configuration. Where master controls slave.

// In master, we have a bundle which is input from a slave and the slave has the same connections as
// output to the master. We can connect the same bundle to the master and to the slave using the bulk
// connector. Listing 2.12 provides an illustration of using flipped and bulk connection.

