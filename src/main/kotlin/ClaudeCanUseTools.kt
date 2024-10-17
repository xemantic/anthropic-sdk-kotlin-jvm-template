// TODO change it to your package
package com.xemantic.anthropic.demo

import com.xemantic.anthropic.Anthropic
import com.xemantic.anthropic.message.Message
import com.xemantic.anthropic.message.ToolResult
import com.xemantic.anthropic.message.ToolUse
import com.xemantic.anthropic.message.plusAssign
import com.xemantic.anthropic.tool.AnthropicTool
import com.xemantic.anthropic.tool.UsableTool
import kotlinx.coroutines.runBlocking

// TODO develop your own tool
@AnthropicTool(
  name = "get_weather",
  description = "Get the weather for a specific location"
)
data class WeatherTool(
  val location: String
): UsableTool {
  override suspend fun use(
    toolUseId: String
  ) = ToolResult(
    toolUseId,
    // in real life it should use some external service to obtain this information
    text = "The weather is 73f"
  )
}

fun main() = runBlocking {

  val client = Anthropic {
    tool<WeatherTool>()
  }

  val conversation = mutableListOf<Message>()
  conversation += Message { +"What is the weather in SF?" }

  val initialResponse = client.messages.create {
    messages = conversation
    useTools()
  }
  println("Initial response:")
  println(initialResponse)

  conversation += initialResponse
  val tool = initialResponse.content.filterIsInstance<ToolUse>().first()
  val toolResult = tool.use()
  conversation += Message { +toolResult }

  val finalResponse = client.messages.create {
    messages = conversation
    useTools()
  }
  println("Final response:")
  println(finalResponse)

}
