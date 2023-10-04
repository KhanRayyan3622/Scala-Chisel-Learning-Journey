package single_cycle

import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
val func3 = Input ( UInt (3. W ) )
// val func7 = Input ( UInt (7. W ) )
val branch = Input ( Bool () )
val x = Input ( UInt (32. W ) )
val y = Input ( UInt (32. W ) )
val isbranch = Output ( Bool () )
}

class BranchControl extends Module {
val io = IO (new LM_IO_Interface_BranchControl )
io.isbranch := 0.B
switch(io.func3)
{
    is(0.U){
        when(io.x===io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }

    }
    is(1.U){
        when(io.x=/=io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }

    }
    is(5.U){
        when(io.x >= io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }

    }
    
    }
    is(7.U){
        when(io.x <= io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }

    }
    is(10.U){
        when(io.x< io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }

    }

    is(11.U){
        when(io.x< io.y){
            io.isbranch:=1.B
        }
        .otherwise{
            io.isbranch:=0.B
        }
    }
}
    

