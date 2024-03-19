package com.jetbrains.kmpapp.presentation.atomic.templates

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.domain.entities.ShoppingItem
import com.jetbrains.kmpapp.presentation.atomic.atoms.IconButtonAtom
import com.jetbrains.kmpapp.presentation.atomic.molecules.ShoppingItemMolecule
import com.jetbrains.kmpapp.presentation.atomic.organisms.EmptyListOrganism
import com.jetbrains.kmpapp.presentation.atomic.organisms.TopBarOrganism
import com.jetbrains.kmpapp.presentation.components.SpacerPadding
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ListTemplate(
    shoppingItems: List<ShoppingItem>,
    onDeleteClick: (ShoppingItem) -> Unit,
    onItemClick: (ShoppingItem) -> Unit,
    onAddItemClick: () -> Unit,
    loading: Boolean = false,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
) {
    Scaffold(
        topBar = {
            TopBarOrganism(
                title = stringResource(MR.strings.list_item_title),
                actions = {
                    IconButtonAtom(
                        painter = painterResource(imageResource = MR.images.ic_add),
                        onClick = onAddItemClick
                    )
                }
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(
                        content = {
                            Text("Item adicionado com sucesso!")
                        }
                    )
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(MR.strings.list_item_subtitle),
                fontSize = 16.sp
            )
            SpacerPadding()
            when {
                loading -> LoadingFullScreen()
                shoppingItems.isEmpty() -> EmptyListOrganism()
                else -> {
                    LazyColumn {
                        items(shoppingItems) { item ->
                            Divider(color = Color(0xFFF4F4F4))
                            ShoppingItemMolecule(
                                modifier = Modifier.clickable {
                                    onItemClick(item)
                                },
                                title = item.title,
                                quantity = item.quantity,
                                onDeleteClick = { onDeleteClick(item) }
                            )
                        }
                    }
                }
            }
        }
    }
}