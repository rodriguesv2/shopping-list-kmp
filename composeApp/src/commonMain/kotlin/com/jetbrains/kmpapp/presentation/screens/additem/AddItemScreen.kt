package com.jetbrains.kmpapp.presentation.screens.additem

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.presentation.atomic.templates.EditItemFormTemplate
import dev.icerock.moko.resources.compose.stringResource

data object AddItemScreen : Screen {
    @Composable
    override fun Content() {
//        val navigator = LocalNavigator.currentOrThrow
        val screenModel: AddItemScreenModel = getScreenModel()

        val state by screenModel.state.collectAsState()

//        AnimatedContent(objects.isNotEmpty()) { objectsAvailable ->
//            if (objectsAvailable) {
//                ObjectGrid(
//                    objects = objects,
//                    onObjectClick = { objectId ->
//                        navigator.push(DetailScreen(objectId))
//                    }
//                )
//            } else {
//                EmptyScreenContent(Modifier.fillMaxSize())
//            }
//        }
        EditItemFormTemplate(
            title = stringResource(MR.strings.add_item_title),
            subtitle = stringResource(MR.strings.add_item_subtitle),
            buttonLabel = stringResource(MR.strings.add_item_create_button_label),
            nameValue = state.itemName,
            quantityValue = state.itemQuantity,
            isButtonEnabled = state.isButtonEnabled,
            isLoading = state.loading,
            onNameChange = screenModel::onNameChange,
            onQuantityChange = screenModel::onQuantityChange,
            onButtonClick = screenModel::onButtonClick,
            onListButtonClick = screenModel::onListButtonClick,
        )
    }
}

//@Composable
//private fun ObjectGrid(
//    objects: List<MuseumObject>,
//    onObjectClick: (Int) -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    LazyRow() { }
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(180.dp),
//        modifier = modifier.fillMaxSize(),
//        contentPadding = PaddingValues(8.dp)
//    ) {
//        items(objects, key = { it.objectID }) { obj ->
//            ObjectFrame(
//                obj = obj,
//                onClick = { onObjectClick(obj.objectID) },
//            )
//        }
//    }
//}
//
//@Composable
//private fun ObjectFrame(
//    obj: MuseumObject,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    Column(
//        modifier
//            .padding(8.dp)
//            .clickable { onClick() }
//    ) {
//        KamelImage(
//            resource = asyncPainterResource(data = obj.primaryImageSmall),
//            contentDescription = obj.title,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1f)
//                .background(Color.LightGray),
//        )
//
//        Spacer(Modifier.height(2.dp))
//
//        Text(
//            obj.title,
//            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
//        )
//        Text(obj.artistDisplayName, style = MaterialTheme.typography.body2)
//        Text(obj.objectDate, style = MaterialTheme.typography.caption)
//    }
//}
