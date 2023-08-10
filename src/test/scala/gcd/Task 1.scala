// package Lab_2
// import chisel3 . _
// import chisel3 . util . _

// class LM_IO_Interface extends Bundle {
// val s0 = Input ( Bool () )
// val s1 = Input ( Bool () )
// val s2 = Input ( Bool () )
// val out = Output ( UInt (32. W ) )
// }
// class Mux_5to1 extends Module {
// val io = IO (new LM_IO_Interface )

// // Start coding here
// //  the Cat function is used to concatenate the three Boolean signals io.s2, io.s1, and io.s0 into a single signal called sel. 
// val sel=Cat(io.s2,io.s1,io.s0)
// // false.B: This is the default value that will be used if none of the case conditions match. In this case, 
// // it's a Boolean constant false.
// // array(: This is the beginning of an array that will hold the case conditions and values for the multiplexer.
// io . out := MuxCase ( false .B , Array (
//     (sel === "b000".U) -> 0.U,  //If sel is "000", the output is 0.
//     (sel === "b001".U) -> 8.U,  //If sel is "001", the output is 8.
//     (sel === "b010".U) -> 16.U,
//     (sel === "b011".U) -> 24.U,
//     (sel === "b100".U) -> 32.U  //If sel is "100", the output is 32
// ))

// }
