//  package Lab4

//  import chisel3 . _
// import chisel3 . util . _

// import fn_3 . _  
//  val fn_3beq = 0.U(3.W)
//  val fn_3bne = 1.U(3.W)
//  val fn_3blt = 2.U(3.W)
//  val fn_3bltu = 3.U(3.W)
//  val fn_3bge = 4.U(3.W)
//  val fn_3bgeu = 5.U(3.W)

//  class branchtest extends Bundle {
// val fnct3 = Input ( UInt (3. W ) )
// val branch = Input ( Bool () )
// val arg_x = Input ( UInt (32. W ) )
// val arg_y = Input ( UInt (32. W ) )
// val br_taken = Output ( Bool () )
// }
// class BranchControl extends Module {
// val io = IO (new LM_IO_Interface_BranchControl )
// io.br_taken := 0.B
// when(io.branch===1.B){
// switch(io.fnct3)
// {
//     is("b000".U){
//         when(io.arg_x===io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b001".U){
//         when(io.arg_x=/=io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b100".U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b101".U){
//         when(io.arg_x >= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b110".U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b111".U){
//         when(io.arg_x>= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }
//     }
// }}
// }