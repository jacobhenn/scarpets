__command() -> '/re b <pattern> to search blocks in world';

b(pattern) -> (
    scan(player() ~ 'pos', 32, 32, 32, 
        if(block(_) ~ pattern != null,
            draw_shape('line', 60, 'from', player() ~ 'pos', 'to', pos(_));
            print('block match: ' + pos(_));
        )
    )
)
