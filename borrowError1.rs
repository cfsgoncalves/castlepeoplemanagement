fn main(){
    let mut x = 5;
    let y = &mut x;

    *y += 1;

    //This will give an error compiling because of line 5. When you have  &mut T you cant have &T 
    println!("{}",x); 

}
