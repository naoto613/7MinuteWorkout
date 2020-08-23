package com.example.pyonsu.a7minuteworkout

class Constants {
    companion object {
        fun defaultExerciseList(): ArrayList<ExerciseModel> {
            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks = ExerciseModel(
                1,
                "飛ぶジャック",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
            exerciseList.add(jumpingJacks)

            val wallSit = ExerciseModel(
                2,
                "空気椅子",
                R.drawable.ic_wall_sit,
                false,
                false)
            exerciseList.add(wallSit)

            val pushUp = ExerciseModel(
                3,
                "腕立て伏せ",
                R.drawable.ic_push_up,
                false,
                false)
            exerciseList.add(pushUp)

            val abdominalCrunch =
                ExerciseModel(
                    4,
                    "腹筋危機",
                    R.drawable.ic_abdominal_crunch,
                    false,
                    false)
            exerciseList.add(abdominalCrunch)

            val stepUpOnChair =
                ExerciseModel(
                    5,
                    "椅子の上のステップアップ",
                    R.drawable.ic_step_up_onto_chair,
                    false,
                    false
                )
            exerciseList.add(stepUpOnChair)

            val squat = ExerciseModel(
                6,
                "スクワット",
                R.drawable.ic_squat,
                false,
                false)
            exerciseList.add(squat)

            val tricepsDipOnChair =
                ExerciseModel(
                    7,
                    "三頭筋は、椅子の上で下がります",
                    R.drawable.ic_triceps_dip_on_chair,
                    false,
                    false
                )
            exerciseList.add(tricepsDipOnChair)

            val plank = ExerciseModel(
                8,
                "板を張ってください",
                R.drawable.ic_plank,
                false,
                false)
            exerciseList.add(plank)

            val highKneesRunningInPlace =
                ExerciseModel(
                    9,
                    "適所に走っている高いひざ",
                    R.drawable.ic_high_knees_running_in_place,
                    false,
                    false
                )
            exerciseList.add(highKneesRunningInPlace)

            val lunges = ExerciseModel(
                10,
                "突進",
                R.drawable.ic_lunge,
                false,
                false)
            exerciseList.add(lunges)

            val pushupAndRotation =
                ExerciseModel(
                    11,
                    "上へプッシュと回転",
                    R.drawable.ic_push_up_and_rotation,
                    false,
                    false
                )
            exerciseList.add(pushupAndRotation)

            val sidePlank = ExerciseModel(
                12,
                "横の厚板",
                R.drawable.ic_side_plank,
                false,
                false)
            exerciseList.add(sidePlank)

            return exerciseList
        }
    }
}