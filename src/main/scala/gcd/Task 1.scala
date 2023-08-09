package Lab_2
import chisel3 . _
import chisel3 . util . _

class LM_IO_Interface extends Bundle {
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( UInt (32. W ) )
}
class Mux_5to1 extends Module {
val io = IO (new LM_IO_Interface )

// Start coding here
val sel=Cat(io.s2,io.s1,io.s0)
io . out := MuxCase ( false .B , Array (
    (sel === "b000".U) -> 0.U,
    (sel === "b001".U) -> 8.U,
    (sel === "b010".U) -> 16.U,
    (sel === "b011".U) -> 24.U,
    (sel === "b100".U) -> 32.U
))

}
