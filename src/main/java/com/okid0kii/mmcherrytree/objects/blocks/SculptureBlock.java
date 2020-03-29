package com.okid0kii.mmcherrytree.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;

public class SculptureBlock extends Block implements IWaterLoggable {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(10.9, 26, 0.9, 11.8, 29, 1.8),
			Block.makeCuboidShape(10.9, 0.1, 0.9, 11.8, 26, 1.8),
			Block.makeCuboidShape(6, 18, 6, 10, 20, 10),
			Block.makeCuboidShape(3, 18, 4, 13, 18.1, 12),
			Block.makeCuboidShape(5, 13, 6, 11, 18, 10),
			Block.makeCuboidShape(7, 14, 5.5, 9, 16, 6),
			Block.makeCuboidShape(9, 18.1, 8, 11, 20.2, 9),
			Block.makeCuboidShape(5, 18.1, 8, 7, 20.2, 9),
			Block.makeCuboidShape(3, 9.1, 6, 5, 13.1, 8),
			Block.makeCuboidShape(3, 8.1, 6, 5, 9.1, 8),
			Block.makeCuboidShape(11, 10.5, 2, 13, 12.5, 7),
			Block.makeCuboidShape(11, 10.5, 1, 13, 12.5, 2),
			Block.makeCuboidShape(3, 4, 7, 7, 8, 10),
			Block.makeCuboidShape(3, 3, 6, 6, 4, 9),
			Block.makeCuboidShape(9, 4, 7, 13, 8, 10),
			Block.makeCuboidShape(10, 3, 6, 13, 4, 9),
			Block.makeCuboidShape(5, 6, 4, 11, 11, 5),
			Block.makeCuboidShape(4, 5, 5, 12, 13, 11),
			Block.makeCuboidShape(7, 5, 11, 9, 10, 12),
			Block.makeCuboidShape(2, 2, 2, 14, 3, 14),
			Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0.9, 26, 4.2, 1.8, 29, 5.1),
			Block.makeCuboidShape(0.9, 0.1, 4.2, 1.8, 26, 5.1),
			Block.makeCuboidShape(6, 18, 6, 10, 20, 10),
			Block.makeCuboidShape(4, 18, 3, 12, 18.1, 13),
			Block.makeCuboidShape(6, 13, 5, 10, 18, 11),
			Block.makeCuboidShape(5.5, 14, 7, 6, 16, 9),
			Block.makeCuboidShape(8, 18.1, 5, 9, 20.2, 7),
			Block.makeCuboidShape(8, 18.1, 9, 9, 20.2, 11),
			Block.makeCuboidShape(6, 9.1, 11, 8, 13.1, 13),
			Block.makeCuboidShape(6, 8.1, 11, 8, 9.1, 13),
			Block.makeCuboidShape(2, 10.5, 3, 7, 12.5, 5),
			Block.makeCuboidShape(1, 10.5, 3, 2, 12.5, 5),
			Block.makeCuboidShape(7, 4, 9, 10, 8, 13),
			Block.makeCuboidShape(6, 3, 10, 9, 4, 13),
			Block.makeCuboidShape(7, 4, 3, 10, 8, 7),
			Block.makeCuboidShape(6, 3, 3, 9, 4, 6),
			Block.makeCuboidShape(4, 6, 5, 5, 11, 11),
			Block.makeCuboidShape(5, 5, 4, 11, 13, 12),
			Block.makeCuboidShape(11, 5, 7, 12, 10, 9),
			Block.makeCuboidShape(2, 2, 2, 14, 3, 14),
			Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(4.2, 26, 14.2, 5.1, 29, 15.1),
			Block.makeCuboidShape(4.2, 0.1, 14.2, 5.1, 26, 15.1),
			Block.makeCuboidShape(6, 18, 6, 10, 20, 10),
			Block.makeCuboidShape(3, 18, 4, 13, 18.1, 12),
			Block.makeCuboidShape(5, 13, 6, 11, 18, 10),
			Block.makeCuboidShape(7, 14, 10, 9, 16, 10.5),
			Block.makeCuboidShape(5, 18.1, 7, 7, 20.2, 8),
			Block.makeCuboidShape(9, 18.1, 7, 11, 20.2, 8),
			Block.makeCuboidShape(11, 9.1, 8, 13, 13.1, 10),
			Block.makeCuboidShape(11, 8.1, 8, 13, 9.1, 10),
			Block.makeCuboidShape(3, 10.5, 9, 5, 12.5, 14),
			Block.makeCuboidShape(3, 10.5, 14, 5, 12.5, 15),
			Block.makeCuboidShape(9, 4, 6, 13, 8, 9),
			Block.makeCuboidShape(10, 3, 7, 13, 4, 10),
			Block.makeCuboidShape(3, 4, 6, 7, 8, 9),
			Block.makeCuboidShape(3, 3, 7, 6, 4, 10),
			Block.makeCuboidShape(5, 6, 11, 11, 11, 12),
			Block.makeCuboidShape(4, 5, 5, 12, 13, 11),
			Block.makeCuboidShape(7, 5, 4, 9, 10, 5),
			Block.makeCuboidShape(2, 2, 2, 14, 3, 14),
			Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(14.2, 26, 10.9, 15.1, 29, 11.8),
			Block.makeCuboidShape(14.2, 0.1, 10.9, 15.1, 26, 11.8),
			Block.makeCuboidShape(6, 18, 6, 10, 20, 10),
			Block.makeCuboidShape(4, 18, 3, 12, 18.1, 13),
			Block.makeCuboidShape(6, 13, 5, 10, 18, 11),
			Block.makeCuboidShape(10, 14, 7, 10.5, 16, 9),
			Block.makeCuboidShape(7, 18.1, 9, 8, 20.2, 11),
			Block.makeCuboidShape(7, 18.1, 5, 8, 20.2, 7),
			Block.makeCuboidShape(8, 9.1, 3, 10, 13.1, 5),
			Block.makeCuboidShape(8, 8.1, 3, 10, 9.1, 5),
			Block.makeCuboidShape(9, 10.5, 11, 14, 12.5, 13),
			Block.makeCuboidShape(14, 10.5, 11, 15, 12.5, 13),
			Block.makeCuboidShape(6, 4, 3, 9, 8, 7),
			Block.makeCuboidShape(7, 3, 3, 10, 4, 6),
			Block.makeCuboidShape(6, 4, 9, 9, 8, 13),
			Block.makeCuboidShape(7, 3, 10, 10, 4, 13),
			Block.makeCuboidShape(11, 6, 5, 12, 11, 11),
			Block.makeCuboidShape(5, 5, 4, 11, 13, 12),
			Block.makeCuboidShape(4, 5, 7, 5, 10, 9),
			Block.makeCuboidShape(2, 2, 2, 14, 3, 14),
			Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
			
		
	public SculptureBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		
		case SOUTH:
			return SHAPE_S;
		
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING,  rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {	
		builder.add(FACING, WATERLOGGED);
	}
	
	@SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if(facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos))
            return Blocks.AIR.getDefaultState();

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
	
	@SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
