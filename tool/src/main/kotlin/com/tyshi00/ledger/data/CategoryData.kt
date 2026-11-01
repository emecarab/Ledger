package com.tyshi00.ledger.data

enum class EntryType(val label: String) {
    INCOME("Income"),
    FIXED("Fixed Expenses"),
    VARIABLE("Expenses"),
    DEBT("Debts"),
}

enum class Frequency(val label: String) {
    ONE_TIME("One-time"),
    WEEKLY("Weekly"),
    BIWEEKLY("Biweekly"),
    BIMONTHLY("Bimonthly"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    ANNUALLY("Annually"),
}

enum class CategoryGroup(val label: String, val type: EntryType) {
    INCOME("Income", EntryType.INCOME),
    EXPENSES("Expenses", EntryType.VARIABLE),
}

enum class DefaultCategory(val label: String, val group: CategoryGroup) {
    // Income
    CINEMA("Cinema", CategoryGroup.INCOME),
    OTHER_INCOME("Other", CategoryGroup.INCOME),

    // Expenses
    EATING_OUT("Eating out", CategoryGroup.EXPENSES),
    FOOD("Food", CategoryGroup.EXPENSES),
    GIFTS("Gifts", CategoryGroup.EXPENSES),
    HOUSE("House", CategoryGroup.EXPENSES),
    SERVICES("Services", CategoryGroup.EXPENSES),
    TRANSPORT("Transport", CategoryGroup.EXPENSES),
    WELLBEING("Wellbeing", CategoryGroup.EXPENSES),
    WORK("Work", CategoryGroup.EXPENSES),
}

data class CategoryItem(
    val id: String,
    val label: String,
    val group: CategoryGroup,
    val isCustom: Boolean,
)

fun DefaultCategory.toItem() = CategoryItem(
    id = name,
    label = label,
    group = group,
    isCustom = false,
)

fun resolveCategory(categoryId: String): String {
    return DefaultCategory.entries.firstOrNull { it.name == categoryId }?.label ?: categoryId
}