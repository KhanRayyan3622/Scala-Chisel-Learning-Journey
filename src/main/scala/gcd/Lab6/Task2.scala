package Lab6
import chisel3 . _
import chisel3 . util . _
class counter_with_xor ( val max : Int = 6) extends Module {
val io = IO (new Bundle {
// val out = Output ( UInt (( log2Ceil ( max ) . W ) ) )
val out =Output (UInt(max.W))
})
val count = RegInit(0.U(4.W))
val msb= count(3)
val counter =msb ^ 1.B
// val io.out:= Mux(counter,(count + 1.U) ,(0.U))
switch(counter)
{
    is(1.B){
    count := count+ 1.U
}
is(0.B){
     count :=0.U
}

}
io.out:= count




}

