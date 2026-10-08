package lopez.ibarra.myapplication.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Ability(type: String, label: String, value: String){
    if(type == "row"){
        Row(){
            Label(label)
            Text(text = value, color = MaterialTheme.colorScheme.onSurface)
        }
    }else{
        Column() {
            Label(label)
            Text(text = value, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Composable
fun Label(text:String){
    Text(
        text = text, 
        color = Color(0xFFE74440), 
        fontWeight = FontWeight.Bold
    )
}
