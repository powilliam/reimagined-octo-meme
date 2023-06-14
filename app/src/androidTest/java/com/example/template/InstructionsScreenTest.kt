package com.example.template

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.template.instructions.InstructionsScreen
import com.example.template.theming.ApplicationTheme
import org.junit.Rule
import org.junit.Test

class InstructionsScreenTest {
    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun main() {
        rule.setContent {
            ApplicationTheme({ rule.activity }) {
                InstructionsScreen()
            }
        }

        rule.onNodeWithText("Instructions")
            .assertExists()
            .assertIsDisplayed()
        rule.onNodeWithTag("listOfInstructions")
            .assertExists()
            .assertIsDisplayed()
        rule.onAllNodesWithTag("instruction")
            .assertCountEquals(4)
    }
}