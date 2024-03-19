package com.jetbrains.kmpapp

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import androidx.compose.ui.window.ComposeUIViewController
import com.jetbrains.kmpapp.utils.lifecycle.LifecycleRegistry
import com.jetbrains.kmpapp.utils.lifecycle.lifecycleCallBack

fun MainViewController() = ComposeUIViewController(
    configure = {
        /**
         * A delegate to track composeViewControllers lifecycle callbacks
         */
        delegate = DelegateLifecycle()
    }
) { App() }

class DelegateLifecycle: ComposeUIViewControllerDelegate {
    override fun viewDidAppear(animated: Boolean) {
        super.viewDidAppear(animated)
        lifecycleCallBack(LifecycleRegistry.onResume)
    }

    override fun viewDidLoad() {
        super.viewDidLoad()
        lifecycleCallBack(LifecycleRegistry.onCreate)
    }

    override fun viewWillDisappear(animated: Boolean) {
        super.viewWillDisappear(animated)
        lifecycleCallBack(LifecycleRegistry.onPause)
    }

    override fun viewWillAppear(animated: Boolean) {
        super.viewWillAppear(animated)
        lifecycleCallBack(LifecycleRegistry.onStart)
    }

    override fun viewDidDisappear(animated: Boolean) {
        super.viewDidDisappear(animated)
        lifecycleCallBack(LifecycleRegistry.onDestroy)
    }
}