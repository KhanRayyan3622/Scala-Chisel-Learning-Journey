package single_cycle
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_BranchControl extends Bundle {
val func3 = Input ( UInt (3. W ) )
val branch = Input ( Bool () )
val x = Input ( UInt (32. W ) )
val y = Input ( UInt (32. W ) )
val br_taken = Output ( Bool () )
}
class BranchControl extends Module {
val io = IO (new LM_IO_Interface_BranchControl )
io.br_taken := 0.B
switch(io.func3)
{
    is(0.U){
        when(io.x===io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }
    is(1.U){
        when(io.x=/=io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }
    is(4.U){
        when(io.x< io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }
    is(5.U){
        when(io.x >= io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }
    is(6.U){
        when(io.x< io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }
    is(7.U){
        when(io.x <= io.y){
            io.br_taken:=1.B
        }
        .otherwise{
            io.br_taken:=0.B
        }

    }}
}
    


