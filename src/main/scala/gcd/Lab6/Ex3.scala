package Lab6
import chisel3 . _
import chisel3 . util . _
class to_shot_timer (val mavWidth : Int) extends Module {
val io = IO (new Bundle {
    val reload = Input(Bool())
    val reset = Input(Bool())
    val din = Input(UInt(mavWidth.W))
    val out = Output(Bool())
})
io.out:=0.B
val timer_count = RegInit (0. U (8. W ) )
val done = timer_count === 0. U
val next = WireInit (0. U )
when (io.reload ) {
timer_count := io.din
io.out := 1.B                     // load the data from input
}
.elsewhen(io.reset ) {
timer_count := io.din
io.out := 1.B                     // load the data from input
}
.elsewhen (! done ) {
timer_count := timer_count - 1. U
io.out:=0.B           // decrement the timer
}
 
}



