package lab2
import chisel3 . _
import chisel3 . util . _
class mux_onehot_4to1 extends Module {
val io = IO (new Bundle {
val in0 = Input ( UInt (4. W ) )
// val in1 = Input ( UInt (32. W ) )
// val in2 = Input ( UInt (32. W ) )
// val in3 = Input ( UInt (32. W ) )
// val sel = Input ( UInt (4. W ) )
val out = Output ( UInt (32. W ) )
})
io . out := Mux1H ( io . in0 , Seq ( 0.U , 1.U ,2.U , 3.U ) )
}
// println (( new chisel3 . stage . ChiselStage ) . emitVerilog (new mux_onehot_4to1 () ) )