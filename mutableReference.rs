fn main(){
    let mut x = 5;
        {
            let y = &mut x;
            println!("{}",y);
            *y += 1;
            println!("{}",y);
        }

        println!("{}", x);


}
