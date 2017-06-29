package com.cooloongwu.coolview.anim;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

/**
 * 控制动画的类
 * Created by CooLoongWu on 2017-6-19 16:56.
 */

public class Anim {

    private static final long DURATION = 1000;
    private static final long NO_DELAY = 0;
    private static final int INFINITE = -1;

    /**
     * 装载动画效果
     *
     * @param animationSets 动画效果
     * @return AnimCreator
     */
    public static AnimCreator with(AnimationSet... animationSets) {
        return new AnimCreator(animationSets);
    }

    private Anim() {
    }


    public static class AnimCreator {
        private long duration = DURATION;
        private long delay = NO_DELAY;
        private boolean isRepeat = false;
        private long repeatTimes = 0;
        private View targetView;

        private AnimationSet[] animationSets;

        AnimCreator(AnimationSet... animationSets) {
            this.animationSets = animationSets;
//            for (AnimAction[] animActions : animActionGroup)
//                for (AnimAction animAction : animActions) {
//                    Log.e("AnimCreator", "action：" + animAction.toString());
//                }
        }

        /**
         * 设置动画的目标视图
         *
         * @param targetView 目标视图
         * @return AnimCreator
         */
        public AnimCreator into(View targetView) {
            this.targetView = targetView;
            Log.e("AnimCreator", "into()");
            return this;
        }

//        /**
//         * 设置动画持续的时间
//         *
//         * @param duration 持续的时间
//         * @return AnimCreator
//         */
//        public AnimCreator setDuration(long duration) {
//            this.duration = duration;
//            Log.e("AnimCreator", "setDuration(" + duration + ")");
//            return this;
//        }
//
//        /**
//         * 动画重复次数
//         *
//         * @param times 次数
//         * @return AnimCreator
//         */
//        public AnimCreator setRepeat(int times) {
//            Log.e("AnimCreator", "setRepeat(" + times + ")");
//            if (times < INFINITE) {
//                throw new RuntimeException("Can not be less than -1, -1 is infinite loop");
//            }
//            isRepeat = times != 0;
//            repeatTimes = times;
//            return this;
//        }


        /**
         * 动画立即开始
         */
        public void start() {
            this.delay = 0;
            Log.e("AnimCreator", "start()");
            run();
        }

        int temp = 0;

        private void run() {
            if (temp == animationSets.length) return;
            Log.e("AnimCreator", "run()");
            AnimationSet animationSet = animationSets[temp];
            targetView.startAnimation(animationSet);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    temp++;
                    run();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }
    }

//        private void run() {
//            if (temp == animActionGroup.length) return;
//            AnimAction[] animActions = animActionGroup[temp];
//            AnimationSet animationSet = new AnimationSet(true);
//            for (AnimAction animAction : animActions) {
//                animationSet.addAnimation(animAction.getAnimation((int) repeatTimes, duration));
//            }
//            animationSet.setFillAfter(true);
//            animationSet.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//                    Log.e("AnimCreator", "onAnimationStart()" + System.currentTimeMillis());
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    Log.e("AnimCreator", "onAnimationEnd()" + System.currentTimeMillis());
//                    temp++;
//                    run();
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//                    Log.e("AnimCreator", "onAnimationRepeat()");
//                }
//            });
//            targetView.setAnimation(animationSet);
//        }

//        /**
//         * 动画延迟开始
//         *
//         * @param delay 延迟时间
//         */
//        public void startDelay(long delay) {
//            Log.e("AnimCreator", "start(" + delay + ")");
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Log.e("AnimCreator", "new Handler().postDelayed()");
//                    targetView.setAnimation(action.getAnimationSet((int) repeatTimes, duration));
//                }
//            }, delay);
//        }


}

