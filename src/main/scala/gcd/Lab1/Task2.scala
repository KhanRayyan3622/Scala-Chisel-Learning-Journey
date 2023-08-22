package Lab1
import chisel3 . _
import chisel3 . util . _
import java . io . File
class Task2 extends Module {
val io = IO (new Bundle {
// val data_in = Input ( UInt ( n . W ) )
val reload = Output ( Bool () )
// val out = Output ( Bool () )
})
val counter = RegInit (0. U(4.W)  )
val max_count = RegInit (9. U (4.W) )
val restart = RegInit(0.B)
when(restart) {
counter := counter - 1.U
}
.otherwise{
counter := counter + 1.U
} 
when(counter === max_count) {
restart := 1.B
 io.reload := 1.B
}
.otherwise{
 io.reload:=0.B
restart := 0.B
}
}