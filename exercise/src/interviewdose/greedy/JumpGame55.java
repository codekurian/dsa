package interviewdose.greedy;

public class JumpGame55 {

	// https://leetcode.com/problems/jump-game/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] nums) {
		boolean canJump = false;
		int maxJumpIndex = nums.length;
		if (maxJumpIndex == 1) {
			return true;
		}
		for (int i = nums.length - 1; i > 0; i--) {
			int jump = nums[i - 1];
			int neededJump = maxJumpIndex - i;

			if (jump >= neededJump) {
				maxJumpIndex = i;
				canJump = true;
			} else {
				canJump = false;
			}

			if (i == 1) {
				return canJump;
			}

		}
		return canJump;
	}
}
