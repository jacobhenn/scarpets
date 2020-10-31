__command() -> '
checkpoint tracker
usage:
/checkpoint on - turn checkpoint tracking on
/checkpoint off - turn checkpoint tracking off
/checkpoint toggle - toggle checkpoint tracking
/checkpoint reset - unlock all checkpoints
/checkpoint last - teleport to the last set checkpoint
/checkpoint here - set the checkpoint to the players current location
/checkpoint block-pre <block> - change the block checkpoints are made of before the player has activated them
/checkpoint block-post <block> - change the block checkpoints are made of after the player has activated them
/checkpoint block-death';

global_is_on = 0;
global_checkpoint = null;
global_pre_block = 'chiseled_quartz';
global_post_block = 'chiseled_quartz';
global_death_block = 'blue_concrete';

go() -> (
    p = player;
    px = p ~ 'x';
    py = p ~ 'y';
    pz = p ~ 'z';
    under_block = block(px, py-1, pz);
    if(under_block == global_death_block,
        modify(player, 'pos', global_checkpoint);
     , under_block == global_pre_block,
        global_checkpoint = (floor(px) + 0.5, py, floor(pz) + 0.5);
    );
);

entity_event(player(), 'on_tick', go());
