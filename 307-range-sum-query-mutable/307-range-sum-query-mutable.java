class NumArray {

	private final int[] tree;
	private final int[] nums;

	public NumArray(int[] nums) {
		this.nums = nums;
		tree = new int[nums.length + 1];
		System.arraycopy(nums, 0, tree, 1, nums.length);
		construct();
	}

	private void construct() {
		for (var i = 1; i < tree.length; i++) {
			var j = i + Integer.lowestOneBit(i);
			if (j < tree.length)
				tree[j] += tree[i];
		}
	}

	private int prefixSum(int i) {
		var sum = 0;		
		for (; i > 0; sum += tree[i], i -= Integer.lowestOneBit(i));
		return sum;
	}

	public void update(int index, int val) {
		var delta = val - nums[index];
		nums[index] = val;
		index++;
		
		for (; index < tree.length; tree[index] += delta, index += Integer.lowestOneBit(index));
	}

	public int sumRange(int left, int right) {
		return prefixSum(right + 1) - prefixSum(left);
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
